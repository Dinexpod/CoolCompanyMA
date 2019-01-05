-- 1. Добавить разработчикам поле (salary - зарплата)
ALTER TABLE developers
  add COLUMN salary int;

-- 2. Найти самый дорогой проект (исходя из salary всех разработчиков)
SELECT projects.project_id,
       projects.name,
       sum(developers.salary)
FROM projects
       JOIN developers_projects
            ON (projects.project_id = developers_projects.project)
       JOIN developers
            ON (developers.developer_id = developers_projects.developer)
GROUP BY projects.project_id
ORDER BY sum(developers.salary) DESC
LIMIT 1

-- 3. Вычислить общую ЗП только Java разработчиков
SELECT sum(salary)
FROM developers
where developer_id IN
      (select developers_skills.developer
       from developers_skills
       where developers_skills.skill IN
             (select skill_id from skills where skills.name = "JAVA")
      )
;

-- 4. Добавить поле (cost - стоимость) в таблицу Projects
ALTER TABLE projects
  add COLUMN cost int;

-- 5. Найти самый дешевый проект (исходя из cost всех проектов)
SELECT project_id, name, cost
from projects
where cost = (select min(cost)
              from projects);

-- 6. Вычислить среднюю ЗП программистов в самом дешевом проекте
SELECT projects.name,
       avg(developers.salary)
FROM projects
       JOIN developers_projects
            ON (projects.project_id = developers_projects.project)
       JOIN developers
            ON (developers.developer_id = developers_projects.developer)
GROUP BY projects.project_id
ORDER BY sum(developers.salary)
LIMIT 1

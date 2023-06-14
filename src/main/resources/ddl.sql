INSERT INTO project (project_name, project_description, project_state)
VALUES ('Project Alpha', 'This is project Alpha.', 'ACTIVE'),
       ('Project Beta', 'This is project Beta.', 'DORMANT'),
       ('Project Gamma', 'This is project Gamma.', 'SHUTDOWN'),
       ('Project Delta', 'This is project Delta.', 'ACTIVE'),
       ('Project Epsilon', 'This is project Epsilon.', 'DORMANT');

INSERT INTO milestone (project_num, milestone_title)
VALUES (1, 'Milestone 1: Initial Setup'),
       (1, 'Milestone 2: Design Phase'),
       (2, 'Milestone 3: Development Phase'),
       (3, 'Milestone 4: Testing Phase'),
       (3, 'Milestone 5: Deployment Phase');

INSERT INTO `task` (project_num, milestone_num, task_title, task_content)
VALUES (1, 1, 'Task 1: Setup development environment', 'Setup the development environment for project Alpha.'),
       (1, 2, 'Task 2: Design the database schema', 'Design the database schema for project Alpha.'),
       (2, 3, 'Task 3: Implement REST API', 'Implement REST API for project Beta.'),
       (3, 4, 'Task 4: Create unit tests', 'Create unit tests for project Gamma.'),
       (4, 5, 'Task 5: Deploy to production', 'Deploy project Delta to production.');

INSERT INTO `comment` (task_num, comment_content, writer_id)
VALUES (1, 'This is a sample comment content #1.', 'john.doe'),
       (2, 'This is a sample comment content #2.', 'jane.doe'),
       (3, 'This is a sample comment content #3.', 'jack.doe'),
       (4, 'This is a sample comment content #4.', 'jill.doe'),
       (5, 'This is a sample comment content #5.', 'jason.doe');


INSERT INTO `tag` (project_num, tag_title)
VALUES (1, 'Frontend'),
       (1, 'Backend'),
       (2, 'API'),
       (3, 'Database'),
       (4, 'Security');


INSERT INTO project_member (project_member_num, project_num, project_role)
VALUES (1, 1, 'PROJECT_ROLE_USER'),
       (2, 1, 'PROJECT_ROLE_USER'),
       (3, 2, 'PROJECT_ROLE_ADMIN'),
       (4, 3, 'PROJECT_ROLE_USER'),
       (5, 4, 'PROJECT_ROLE_USER');




INSERT INTO task_tag (tag_num, task_num)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 3),
       (5, 4);


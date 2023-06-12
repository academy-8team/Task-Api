CREATE TABLE IF NOT EXISTS `projects`
(
    project_id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date        DATETIME,
    last_modified_date  DATETIME,
    project_name        VARCHAR(30) NOT NULL,
    project_description VARCHAR(200),
    project_status      ENUM ('ACTIVE', 'DORMANT', 'SHUTDOWN')
);

CREATE TABLE IF NOT EXISTS `milestones`
(
    milestone_id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date       DATETIME,
    last_modified_date DATETIME,
    milestone_title    VARCHAR(30) NOT NULL,
    project_id         BIGINT,
    FOREIGN KEY (project_id) REFERENCES `projects` (project_id)
);

CREATE TABLE IF NOT EXISTS `project_members`
(
    project_member_id  BIGINT,
    project_id         BIGINT,
    created_date       DATETIME,
    last_modified_date DATETIME,
    project_role       ENUM ('PROJECT_ROLE_ADMIN', 'PROJECT_ROLE_USER'),
    PRIMARY KEY (project_member_id, project_id),
    FOREIGN KEY (project_id) REFERENCES `projects` (project_id)
);

CREATE TABLE IF NOT EXISTS tags
(
    tag_id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date       DATETIME,
    last_modified_date DATETIME,
    project_id         BIGINT,
    tag_title          VARCHAR(255),
    FOREIGN KEY (project_id) REFERENCES `projects` (project_id)
);

CREATE TABLE IF NOT EXISTS tasks
(
    task_id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date       DATETIME,
    last_modified_date DATETIME,
    project_id         BIGINT,
    task_title         VARCHAR(255),
    task_content       TEXT,
    milestone_id       BIGINT,
    FOREIGN KEY (project_id) REFERENCES `projects` (project_id),
    FOREIGN KEY (milestone_id) REFERENCES `milestones` (milestone_id)
);

CREATE TABLE IF NOT EXISTS `comments`
(
    comment_id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date       DATETIME,
    last_modified_date DATETIME,
    task_id            BIGINT,
    comment_content    TEXT,
    FOREIGN KEY (task_id) REFERENCES tasks (task_id)
);

CREATE TABLE IF NOT EXISTS `task_tags`
(
    tag_id             BIGINT,
    task_id            BIGINT,
    created_date       DATETIME,
    last_modified_date DATETIME,
    PRIMARY KEY (tag_id, task_id),
    FOREIGN KEY (tag_id) REFERENCES tags (tag_id),
    FOREIGN KEY (task_id) REFERENCES tasks (task_id)
);

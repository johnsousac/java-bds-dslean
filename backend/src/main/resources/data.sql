INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES('Bootcamp HTML', 'https://www.google.com/imgres?imgurl=https%3A%2F%2Fget.pxhere.com%2Fphoto%2Ftraining-course-training-online-courses-learning-course-icons-education-class-educational-courses-study-business-course-business-suit-full-background-presentation-hand-professional-handsome-executive-people-showing-male-smile-manager-lsmart-entrepreneur-portrait-studio-copyspace-businessman-single-boss-career-communication-confident-copy-corporate-fresh-public-speaking-standing-text-human-behavior-orator-conversation-line-job-organization-font-angle-businessperson-brand-1443423.jpg&imgrefurl=https%3A%2F%2Fpxhere.com%2Fen%2Fphoto%2F1443423&tbnid=6BuxmLKXGYHzlM&vet=12ahUKEwjXvN3pw9n6AhV_MrkGHe6sC4AQMygAegQIARBJ..i&docid=5uq7y_qYaznNgM&w=2250&h=2000&q=courses%20img&hl=pt-BR&ved=2ahUKEwjXvN3pw9n6AhV_MrkGHe6sC4AQMygAegQIARBJ', 'https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.picpedia.org%2Fkeyboard%2Fimages%2Faccredited-training-courses.jpg&imgrefurl=https%3A%2F%2Fwww.picpedia.org%2Fkeyboard%2Fa%2Faccredited-training-courses.html&tbnid=fT6h6Zbnk-PY0M&vet=12ahUKEwjXvN3pw9n6AhV_MrkGHe6sC4AQMygEegQIARBV..i&docid=N3qsCsjHXNoObM&w=1200&h=800&q=courses%20img&hl=pt-BR&ved=2ahUKEwjXvN3pw9n6AhV_MrkGHe6sC4AQMygEegQIARBV');

INSERT INTO tb_offer(edition, start_moment, end_moment, course_id) VALUES('1.0', TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2020-11-21T03:00:00Z', 1);
INSERT INTO tb_offer(edition, start_moment, end_moment, course_id) VALUES('1.0', TIMESTAMP WITH TIME ZONE '2020-12-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2020-12-21T03:00:00Z', 1);

INSERT INTO tb_resource(title, description, position, img_uri, type, offer_id) VALUES('Trilha HTML', 'Trilha principal do curso', 1, 'http://imagem-teste.com', 1, 1);
INSERT INTO tb_resource(title, description, position, img_uri, type, offer_id) VALUES('Forum', 'Tire suas duvidas', 2, 'http://imagem-teste.com', 2, 1);
INSERT INTO tb_resource(title, description, position, img_uri, type, offer_id) VALUES('Lives', 'Lives exclusivas para a turma', 3, 'http://imagem-teste.com', 0, 1);

INSERT INTO tb_section(title, description, position, img_uri, resource_id, prerequisite_id) VALUES('Capitulo 1', 'Neste capitulo vamos começar', 1, 'http://imagem-teste.com', 1, null);
INSERT INTO tb_section(title, description, position, img_uri, resource_id, prerequisite_id) VALUES('Capitulo 2', 'Neste capitulo vamos continuar', 2, 'http://imagem-teste.com', 1, 1);
INSERT INTO tb_section(title, description, position, img_uri, resource_id, prerequisite_id) VALUES('Capitulo 3', 'Neste capitulo vamos finalizar', 3, 'http://imagem-teste.com', 1, 2);

INSERT INTO tb_enrollment(user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES(1, 1, TIMESTAMP WITH TIME ZONE '2020-11-20T13:00:00Z', null, true, false);
INSERT INTO tb_enrollment(user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES(2, 1, TIMESTAMP WITH TIME ZONE '2020-11-20T13:00:00Z', null, true, false);

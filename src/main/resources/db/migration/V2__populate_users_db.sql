INSERT INTO roles(name) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

INSERT INTO users (username, password, role_id) VALUES
('Crock', '$2a$10$Z6/jssTAZCoiS82TAOCSj.1yWHtAnwhFovLmH.01tcZ7i58uwvequ', 1),
('user', '$2a$10$J2P51OJupejO16O23gyYmO4TGyoH.69KVGE/3xmmnm1QH.HeLkUxe', 2),
('user2', '$2a$10$xmQZotoO0GpInPxl7CeqU.PGoGArhbQwpkxwPN33E8tciwbyd79mq', 2),
('sambuka', '$2a$10$NovrCRu.a.t8Hqm7ZL6lB.3fz1Gf8m72CL/lVOs0dCdwqm2Da4ZIO', 2),
('user3', '$2a$10$gBDdRA40x837qstP7IMfze16vkTpHROQc2LvcF3Mcz8p/HO3Q2Fwi', 2);
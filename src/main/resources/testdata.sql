-- テスト用データ(ADMIN権限)
insert into m_user(user_id, password, user_name, birthday, age, marrige, role)
values('test@example.com', '$2a$10$7WwzJtw1PUd.CzgXfNw0TOpOs2z5dVeNL0hpJ28HBZs0kzXjmPu5W', 'test', '1990-06-13', 29, false, 'ROLE_ADMIN');
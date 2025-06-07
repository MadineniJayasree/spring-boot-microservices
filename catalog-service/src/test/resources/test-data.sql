truncate table products;

INSERT INTO products (code, name, description, image_url, price) VALUES
-- Fiction
('B001', 'To Kill a Mockingbird', 'Classic fiction by Harper Lee', 'https://example.com/images/mockingbird.jpg', 12.99),
('B002', '1984', 'Dystopian fiction by George Orwell', 'https://example.com/images/1984.jpg', 10.49),
('B003', 'The Great Gatsby', 'Novel by F. Scott Fitzgerald', 'https://example.com/images/gatsby.jpg', 9.99),
('B004', 'Life of Pi', 'Adventure fiction by Yann Martel', 'https://example.com/images/lifeofpi.jpg', 11.99),
('B005', 'The Book Thief', 'Historical fiction by Markus Zusak', 'https://example.com/images/bookthief.jpg', 13.50),

-- Thriller
('B006', 'Gone Girl', 'Psychological thriller by Gillian Flynn', 'https://example.com/images/gonegirl.jpg', 14.00),
('B007', 'The Silent Patient', 'Bestselling thriller by Alex Michaelides', 'https://example.com/images/silentpatient.jpg', 13.99),
('B008', 'The Girl with the Dragon Tattoo', 'Mystery thriller by Stieg Larsson', 'https://example.com/images/dragontattoo.jpg', 12.75),
('B009', 'The Da Vinci Code', 'Thriller by Dan Brown', 'https://example.com/images/davinci.jpg', 11.49),
('B010', 'Shutter Island', 'Psychological thriller by Dennis Lehane', 'https://example.com/images/shutterisland.jpg', 10.99),

-- Novels
('B011', 'Pride and Prejudice', 'Romantic novel by Jane Austen', 'https://example.com/images/pride.jpg', 9.49),
('B012', 'Jane Eyre', 'Gothic novel by Charlotte Brontë', 'https://example.com/images/janeeyre.jpg', 10.75),
('B013', 'Wuthering Heights', 'Classic novel by Emily Brontë', 'https://example.com/images/wuthering.jpg', 10.25),
('B014', 'A Tale of Two Cities', 'Historical novel by Charles Dickens', 'https://example.com/images/twocities.jpg', 8.99),
('B015', 'The Kite Runner', 'Emotional novel by Khaled Hosseini', 'https://example.com/images/kiterunner.jpg', 12.89),
('B016', 'One Hundred Years of Solitude', 'Magical realism novel by Gabriel García Márquez', 'https://example.com/images/solitude.jpg', 14.59),
('B017', 'A Man Called Ove', 'Heartwarming novel by Fredrik Backman', 'https://example.com/images/ove.jpg', 13.00),
('B018', 'The Alchemist', 'Philosophical novel by Paulo Coelho', 'https://example.com/images/alchemist.jpg', 11.00),
('B019', 'The Shadow of the Wind', 'Mystery novel by Carlos Ruiz Zafón', 'https://example.com/images/shadowwind.jpg', 13.99),
('B020', 'The Catcher in the Rye', 'Coming-of-age novel by J.D. Salinger', 'https://example.com/images/catcher.jpg', 9.99);

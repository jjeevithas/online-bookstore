INSERT INTO books (title, author, description, price, image_url)
SELECT 'The Alchemist', 'Paulo Coelho', 'A classic novel about following dreams and discovering your purpose.', 399.00, 'https://covers.openlibrary.org/b/isbn/9780062315007-L.jpg'
WHERE NOT EXISTS (SELECT 1 FROM books WHERE title='The Alchemist');

INSERT INTO books (title, author, description, price, image_url)
SELECT 'Atomic Habits', 'James Clear', 'A practical guide to building good habits and breaking bad ones.', 499.00, 'https://covers.openlibrary.org/b/isbn/9780735211292-L.jpg'
WHERE NOT EXISTS (SELECT 1 FROM books WHERE title='Atomic Habits');

INSERT INTO books (title, author, description, price, image_url)
SELECT 'Clean Code', 'Robert C. Martin', 'A handbook of agile software craftsmanship and maintainable code.', 699.00, 'https://covers.openlibrary.org/b/isbn/9780132350884-L.jpg'
WHERE NOT EXISTS (SELECT 1 FROM books WHERE title='Clean Code');

INSERT INTO books (title, author, description, price, image_url)
SELECT 'Rich Dad Poor Dad', 'Robert T. Kiyosaki', 'Personal finance lessons presented through two contrasting perspectives.', 349.00, 'https://covers.openlibrary.org/b/isbn/9781612681139-L.jpg'
WHERE NOT EXISTS (SELECT 1 FROM books WHERE title='Rich Dad Poor Dad');

INSERT INTO books (title, author, description, price, image_url)
SELECT 'The Pragmatic Programmer', 'Andrew Hunt and David Thomas', 'Practical techniques for becoming a better and more effective programmer.', 799.00, 'https://covers.openlibrary.org/b/isbn/9780135957059-L.jpg'
WHERE NOT EXISTS (SELECT 1 FROM books WHERE title='The Pragmatic Programmer');

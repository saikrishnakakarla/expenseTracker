INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(1, 'Food', NULL, 'EXPENSE'),
(2, 'Transport', NULL, 'EXPENSE'),
(3, 'Housing', NULL, 'EXPENSE'),
(4, 'Utilities', NULL, 'EXPENSE'),
(5, 'Health', NULL, 'EXPENSE'),
(6, 'Education', NULL, 'EXPENSE'),
(7, 'Shopping', NULL, 'EXPENSE'),
(8, 'Entertainment', NULL, 'EXPENSE'),
(9, 'Travel', NULL, 'EXPENSE'),
(10, 'Subscriptions', NULL, 'EXPENSE'),
(11, 'Personal Care', NULL, 'EXPENSE'),
(12, 'Miscellaneous', NULL, 'EXPENSE'),
(13, 'Insurance', NULL, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(101, 'Groceries', 1, 'EXPENSE'),
(102, 'Dining Out', 1, 'EXPENSE'),
(103, 'Coffee / Tea', 1, 'EXPENSE'),
(104, 'Snacks', 1, 'EXPENSE'),
(105, 'Food Delivery', 1, 'EXPENSE'),
(106, 'Vegetables', 1, 'EXPENSE'),
(107, 'Eggs', 1, 'EXPENSE'),
(108, 'Chicken', 1, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(201, 'Fuel - Bike', 2, 'EXPENSE'),
(202, 'Taxi / Cab', 2, 'EXPENSE'),
(203, 'Public Transport', 2, 'EXPENSE'),
(204, 'Vehicle Maintenance', 2, 'EXPENSE'),
(205, 'Parking / Tolls', 2, 'EXPENSE'),
(206, 'Fuel - Car', 2, 'EXPENSE'),
(207, 'Insurance - Bike', 2, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(301, 'Rent', 3, 'EXPENSE'),
(302, 'Home Maintenance', 3, 'EXPENSE'),
(303, 'Property Tax', 3, 'EXPENSE'),
(304, 'Home Insurance', 3, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(401, 'Electricity', 4, 'EXPENSE'),
(402, 'Water', 4, 'EXPENSE'),
(403, 'Gas', 4, 'EXPENSE'),
(404, 'Internet', 4, 'EXPENSE'),
(405, 'Mobile Recharge', 4, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(501, 'Vasudha - Health', 5, 'EXPENSE'),
(502, 'Home - Health', 5, 'EXPENSE'),
(503, 'Sai - Health', 5, 'EXPENSE'),
(504, 'Fitness / Gym', 5, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(601, 'School / College Fees', 6, 'EXPENSE'),
(602, 'Online Courses', 6, 'EXPENSE'),
(603, 'Books', 6, 'EXPENSE'),
(604, 'Coaching / Training', 6, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(701, 'Clothing', 7, 'EXPENSE'),
(702, 'Electronics', 7, 'EXPENSE'),
(703, 'Home Items', 7, 'EXPENSE'),
(704, 'Gifts', 7, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(801, 'Movies', 8, 'EXPENSE'),
(802, 'Games', 8, 'EXPENSE'),
(803, 'Events / Concerts', 8, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(901, 'Flights', 9, 'EXPENSE'),
(902, 'Hotels', 9, 'EXPENSE'),
(903, 'Local Transport', 9, 'EXPENSE'),
(904, 'Trip', 9, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(1001, 'Music', 10, 'EXPENSE'),
(1002, 'Video Streaming', 10, 'EXPENSE'),
(1003, 'Software / Tools', 10, 'EXPENSE'),
(1004, 'Cloud Services', 10, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(1101, 'Salon / Grooming', 11, 'EXPENSE'),
(1102, 'Skincare', 11, 'EXPENSE'),
(1103, 'Wellness', 11, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(1201, 'Donations', 12, 'EXPENSE'),
(1202, 'Penalties / Fines', 12, 'EXPENSE'),
(1203, 'Uncategorized', 12, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(1301, 'Health Insurance', 13, 'EXPENSE'),
(1302, 'Life Insurance', 13, 'EXPENSE'),
(1303, 'Bike Insurance', 13, 'EXPENSE');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(2001, 'Salary', NULL, 'INCOME'),
(2002, 'Business Income', NULL, 'INCOME'),
(2003, 'Investments', NULL, 'INCOME'),
(2004, 'Interest', NULL, 'INCOME'),
(2005, 'Other Income', NULL, 'INCOME');

INSERT INTO transaction_categories (id, name, parent_id, category_type) VALUES
(2101, 'Monthly Salary', 2001, 'INCOME'),
(2102, 'Bonus', 2001, 'INCOME'),

(2201, 'Freelance', 2002, 'INCOME'),
(2202, 'Consulting', 2002, 'INCOME'),

(2301, 'Short Term Capital Gains', 2003, 'INCOME'),
(2302, 'Long Term Capital Gains', 2003, 'INCOME'),
(2303, 'Dividends', 2003, 'INCOME'),

(2401, 'Savings Interest', 2004, 'INCOME'),
(2402, 'FD Interest', 2004, 'INCOME'),

(2501, 'Gifts Received', 2005, 'INCOME');


INSERT INTO category_keywords VALUES
('grocery', 101),
('groceries', 101),
('vegetable', 101),
('vegetables', 101),
('fruit', 101),
('fruits', 101),
('rice', 101),
('dal', 101),
('lentils', 101),
('oil', 101),
('milk', 101),
('curd', 101),
('yogurt', 101),
('paneer', 101),
('cheese', 101),
('butter', 101),
('egg', 101),
('eggs', 101),
('chicken', 101),
('meat', 101),
('mutton', 101),
('fish', 101),
('shrimp', 101),
('prawns', 101);

INSERT INTO category_keywords VALUES
('restaurant', 102),
('hotel', 102),
('dinner', 102),
('lunch', 102),
('breakfast', 102),
('meal', 102),
('dine', 102),
('buffet', 102);

INSERT INTO category_keywords VALUES
('coffee', 103),
('tea', 103),
('chai', 103),
('cafe', 103),
('latte', 103),
('espresso', 103);

INSERT INTO category_keywords VALUES
('snack', 104),
('snacks', 104),
('chips', 104),
('biscuits', 104),
('cookies', 104),
('chocolate', 104),
('namkeen', 104),
('buttermilk', 104);

INSERT INTO category_keywords VALUES
('petrol', 201),
('diesel', 206),
('fuel', 201),
('bikeservice', 204),
('car', 206),
('bikepetrol', 201),
('carpetrol', 206);

INSERT INTO category_keywords VALUES
('uber', 202),
('ola', 202),
('cab', 202),
('taxi', 202),
('ride', 202);

INSERT INTO category_keywords VALUES
('bus', 203),
('metro', 203),
('train', 203),
('auto', 203),
('ticket', 203);

INSERT INTO category_keywords VALUES
('rent', 301),
('maintenance', 302),
('propertytax', 303),
('homeinsurance', 304);

INSERT INTO category_keywords VALUES
('electricity', 401),
('current', 401),
('currentbill', 401),
('electricitybill', 401),
('power', 401),
('powerbill', 401),
('water', 402),
('gas', 403),
('internet', 404),
('wifi', 404),
('mobile', 405),
('recharge', 405);

INSERT INTO category_keywords VALUES
('vasudhahealth', 501),
('homehealth', 502),
('saihealth', 503),
('gym', 504),
('fitness', 504);

INSERT INTO category_keywords VALUES
('fees', 601),
('school', 601),
('college', 601),
('course', 602),
('onlinecourse', 602),
('books', 603),
('training', 604),
('coaching', 604);

INSERT INTO category_keywords VALUES
('clothes', 701),
('clothing', 701),
('dress', 701),
('electronics', 702),
('mobilephone', 702),
('laptop', 702),
('homeitems', 703),
('gift', 704),
('gifts', 704);

INSERT INTO category_keywords VALUES
('movie', 801),
('movies', 801),
('cinema', 801),
('game', 802),
('games', 802),
('concert', 803),
('event', 803);

INSERT INTO category_keywords VALUES
('flight', 901),
('flights', 901),
('hotelroom', 902),
('stay', 902),
('transport', 903),
('sightseeing', 904),
('trip', 904);

INSERT INTO category_keywords VALUES
('subscription', 1001),
('spotify', 1001),
('music', 1001),
('streaming', 1002),
('HotStar', 1002),
('ETvWIN', 1002),
('software', 1003),
('tool', 1003),
('cloud', 1004);

INSERT INTO category_keywords VALUES
('salon', 1101),
('grooming', 1101),
('haircut', 1101),
('skincare', 1102),
('wellness', 1103),
('spa', 1103);

INSERT INTO category_keywords VALUES
('donation', 1201),
('fine', 1202),
('penalty', 1202),
('misc', 1203),
('unknown', 1203),
('Miscellaneous',12);

INSERT INTO category_keywords VALUES
('insurance', 1301),
('healthinsurance', 1301),
('lifeinsurance', 1302),
('bikeinsurance', 1303);

INSERT INTO category_keywords VALUES
('salary', 2101),
('pay', 2101),
('income', 2101),
('bonus', 2102);

INSERT INTO category_keywords VALUES
('stcg', 2301),
('shorttermgain', 2301),
('ltcg', 2302),
('longtermgain', 2302),
('dividend', 2303);

INSERT INTO category_keywords VALUES
('interest', 2401),
('fdinterest', 2402),
('bankinterest', 2401);

INSERT INTO category_keywords VALUES
('giftreceived', 2501),
('cashgift', 2501);


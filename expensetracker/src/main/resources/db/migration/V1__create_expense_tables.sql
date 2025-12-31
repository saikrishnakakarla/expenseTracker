create table users (
  user_id UUID primary key,
  telegram_user_id BIGINT unique not null,
  user_name varchar(40),
  mobile_num varchar(15),
  created_at timestamp not null default now(),
  updated_at timestamp,
  is_deleted boolean not null default false
);

create table transaction_categories (
  id integer primary key,
  name varchar(40) not null,
  parent_id integer references transaction_categories(id),

  category_type varchar(10) not null
    check (category_type in ('EXPENSE', 'INCOME'))
);

create table transactions (
  id UUID primary key,
  user_id UUID not null references users(user_id),

  transaction_type varchar(10) not null
    check (transaction_type in ('EXPENSE', 'INCOME')),

  category_id integer references transaction_categories(id),

  amount numeric(12,2) not null,
  currency varchar(3) not null,

  transaction_date timestamp not null,
  created_at timestamp not null default now(),

  raw_text text
);


create table category_keywords (
  keyword varchar(30) primary key,
  category_id integer not null references transaction_categories(id)
);

create index idx_tx_user_date
  on transactions(user_id, transaction_date);

create index idx_tx_category
  on transactions(category_id);

create index idx_tx_type
  on transactions(transaction_type);

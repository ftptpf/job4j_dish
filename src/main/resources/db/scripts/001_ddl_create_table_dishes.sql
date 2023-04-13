CREATE TABLE IF NOT EXISTS dishes (
    id SERIAL PRIMARY KEY NOT NULL ,
    name TEXT UNIQUE NOT NULL ,
    description TEXT NOT NULL
);

COMMENT ON TABLE dishes IS 'Блюда';
COMMENT ON COLUMN dishes.id IS 'Идентификатор блюда';
COMMENT ON COLUMN dishes.name IS 'Название блюда';
COMMENT ON COLUMN dishes.description IS 'Описание состава блюда';

-- -----------------------------------------------------
-- Table "endereco"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "endereco" ;

CREATE TABLE IF NOT EXISTS "endereco" (
  "id" SERIAL,
  "bairro" VARCHAR(45) NOT NULL,
  "rua" VARCHAR(255) NOT NULL,
  "numero" VARCHAR(10) NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "usuario"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "usuario" ;

CREATE TABLE IF NOT EXISTS "usuario" (
  "id" SERIAL,
  "endereco_id" INT NOT NULL,
  "nome" VARCHAR(255) NOT NULL,
  "nascimento" DATE NOT NULL,
  "login" VARCHAR(45) NOT NULL,
  "password" VARCHAR(45) NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_usuario_endereco"
    FOREIGN KEY ("endereco_id")
    REFERENCES "endereco" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "posto_saude"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "posto_saude" ;

CREATE TABLE IF NOT EXISTS "posto_saude" (
  "id" SERIAL,
  "nome" VARCHAR(255) NULL,
  "endereco_id" INT NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_posto_saude_endereco1"
    FOREIGN KEY ("endereco_id")
    REFERENCES "endereco" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "paciente"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "paciente" ;

CREATE TABLE IF NOT EXISTS "paciente" (
  "id" SERIAL,
  "cpf" VARCHAR(11) NULL,
  "usuario_id" INT NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_paciente_usuario1"
    FOREIGN KEY ("usuario_id")
    REFERENCES "usuario" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "consulta"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "consulta" ;

CREATE TABLE IF NOT EXISTS "consulta" (
  "id" SERIAL,
  "descricao" VARCHAR(45) NULL,
  "paciente_id" INT NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_consulta_paciente1"
    FOREIGN KEY ("paciente_id")
    REFERENCES "paciente" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "agenda"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "agenda" ;

CREATE TABLE IF NOT EXISTS "agenda" (
  "id" SERIAL,
  "data" DATE NULL,
  "status" VARCHAR(45) NULL,
  "consulta_id" INT NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_agenda_consulta1"
    FOREIGN KEY ("consulta_id")
    REFERENCES "consulta" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "medico"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "medico" ;

CREATE TABLE IF NOT EXISTS "medico" (
  "id" SERIAL,
  "crm" VARCHAR(45) NULL,
  "usuario_id" INT NOT NULL,
  "agenda_id" INT NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_medico_usuario1"
    FOREIGN KEY ("usuario_id")
    REFERENCES "usuario" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_medico_agenda1"
    FOREIGN KEY ("agenda_id")
    REFERENCES "agenda" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "medico_has_consulta"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "medico_has_consulta" ;

CREATE TABLE IF NOT EXISTS "medico_has_consulta" (
  "medico_id" INT NOT NULL,
  "consulta_id" INT NOT NULL,
  PRIMARY KEY ("medico_id", "consulta_id"),
  CONSTRAINT "fk_medico_has_consulta_medico1"
    FOREIGN KEY ("medico_id")
    REFERENCES "medico" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_medico_has_consulta_consulta1"
    FOREIGN KEY ("consulta_id")
    REFERENCES "consulta" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "medico_has_posto_saude"
-- -----------------------------------------------------
DROP TABLE IF EXISTS "medico_has_posto_saude" ;

CREATE TABLE IF NOT EXISTS "medico_has_posto_saude" (
  "medico_id" INT NOT NULL,
  "posto_saude_id" INT NOT NULL,
  PRIMARY KEY ("medico_id", "posto_saude_id"),
  CONSTRAINT "fk_medico_has_posto_saude_medico1"
    FOREIGN KEY ("medico_id")
    REFERENCES "medico" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_medico_has_posto_saude_posto_saude1"
    FOREIGN KEY ("posto_saude_id")
    REFERENCES "posto_saude" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
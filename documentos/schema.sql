-- -----------------------------------------------------
-- Table "endereco"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS endereco (
  "idendereco" SERIAL,
  "rua" VARCHAR(45) NULL,
  "numero" INT NULL,
  "bairro" VARCHAR(45) NULL,
  "estado" VARCHAR(45) NULL,
  "pais" VARCHAR(45) NULL,
  PRIMARY KEY ("idendereco"));


-- -----------------------------------------------------
-- Table "unidadedesaude"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS unidadedesaude (
  "idunidadedesaude" SERIAL,
  "nome" VARCHAR(45) NULL,
  PRIMARY KEY ("idunidadedesaude"));


-- -----------------------------------------------------
-- Table "usuario"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
  "idusuario" SERIAL,
  "login" VARCHAR(45) NULL,
  "senha" VARCHAR(45) NULL,
  "nome" VARCHAR(45) NULL,
  "telefone" VARCHAR(45) NULL,
  "idendereco" INT NOT NULL,
  "idunidadedesaude" INT NOT NULL,
  PRIMARY KEY ("idusuario"),
  CONSTRAINT "fk_usuario_endereco1"
    FOREIGN KEY ("idendereco")
    REFERENCES endereco ("idendereco")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_usuario_unidadedesaude1"
    FOREIGN KEY ("idunidadedesaude")
    REFERENCES unidadedesaude ("idunidadedesaude")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "paciente"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS paciente (
  "cpf" VARCHAR(45) NOT NULL,
  "idpaciente" SERIAL,
  "idusuario" INT NOT NULL,
  PRIMARY KEY ("idpaciente"),
  CONSTRAINT "fk_paciente_usuario"
    FOREIGN KEY ("idusuario")
    REFERENCES usuario ("idusuario")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "medico"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS medico (
  "idmedico" SERIAL,
  "crm" VARCHAR(45) NULL,
  "idusuario" INT NOT NULL,
  PRIMARY KEY ("idmedico"),
  CONSTRAINT "fk_medico_usuario1"
    FOREIGN KEY ("idusuario")
    REFERENCES usuario ("idusuario")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "funcionario"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionario (
  "idfuncionario" SERIAL,
  "idusuario" INT NOT NULL,
  "matricula" VARCHAR(45) NULL,
  PRIMARY KEY ("idfuncionario"),
  CONSTRAINT "fk_funcionario_usuario1"
    FOREIGN KEY ("idusuario")
    REFERENCES usuario ("idusuario")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "administrador"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS administrador (
  "idadministrador" SERIAL,
  "codadministrador" INT NULL,
  "idusuario" INT NOT NULL,
  PRIMARY KEY ("idadministrador"),
  CONSTRAINT "fk_administrador_usuario1"
    FOREIGN KEY ("idusuario")
    REFERENCES usuario ("idusuario")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "agenda"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS agenda (
  "idagenda" SERIAL,
  "data" DATE NULL,
  "horario" VARCHAR(45) NULL,
  "idmedico" INT NOT NULL,
  "disponibilidade" VARCHAR(45) NULL,
  PRIMARY KEY ("idagenda"),
  CONSTRAINT "fk_agenda_medico1"
    FOREIGN KEY ("idmedico")
    REFERENCES medico ("idmedico")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "consulta"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS consulta (
  "idconsulta" SERIAL,
  "idagenda" INT NOT NULL,
  "idpaciente" INT NOT NULL,
  PRIMARY KEY ("idconsulta"),
  CONSTRAINT "fk_consulta_agenda1"
    FOREIGN KEY ("idagenda")
    REFERENCES agenda ("idagenda")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_consulta_paciente1"
    FOREIGN KEY ("idpaciente")
    REFERENCES paciente ("idpaciente")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



select * from usuario;
select * from endereco;
select * from unidadedesaude;

insert into endereco ("rua", "numero", "bairro", "estado", "pais")
VALUES ('rua do marcos', 15, 'heliopolis', 'pernambuco', 'brasil');

INSERT INTO unidadedesaude ("nome") 
VALUES ('unidade caucaia');


-- cria usuario para testar listagem
insert into usuario ("login", "senha", "nome", "telefone", "idendereco", "idunidadedesaude") 
VALUES ('conta', 'senha123', 'davi', '87992612633', 1, 1);

/*
{
    "idUsuario": 3,
    "login": "logindemedico",
    "senha": "senhademedico",
    "nome": "nomedepedico",
    "telefone": "1287312",
    "endereco": {
        "idEndereco": 0,
        "rua": "ruademedico",
        "numero": 15,
        "bairro": "bairrodemedico",
        "estado": "estadodemedico",
        "pais": "brasil"
    },
    "unidade": {
        "idUnidade": 1,
        "nome": "unidade caucaia"
    },
    "unidadeDeSaude": {
        "idUnidade": 1,
        "nome": "unidade caucaia"
    },
    "tipoUsuario": 1,
    "cpf": "128378239",
}
  tipoUsuario 1 = paciente
  tipoUsuario 2 = medico
  tipoUsuario 3 = funcionario (nao fiz ainda)
  crm/cpf devem ser preenchidos no json
*/


-- cria agenda para testar listagem
insert into agenda ("data", "horario", "medico_idmedico", "disponibilidade")
  values ('2022-02-21', '2022-02-21 15:16:17', 1, 1)
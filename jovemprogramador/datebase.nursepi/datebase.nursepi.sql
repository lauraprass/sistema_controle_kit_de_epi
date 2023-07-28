CREATE SCHEMA IF NOT EXISTS `nursepi` DEFAULT CHARACTER SET utf8 ;
USE `nursepi` ;

-- -----------------------------------------------------
-- Table `nursepi`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nursepi`.`Pessoa` (
  `idpessoa` INT NOT NULL AUTO_INCREMENT,
  `nome_pessoa` VARCHAR(45) NOT NULL,
  `telefone_pessoa` VARCHAR(45) NOT NULL,
  `email_pessoa` VARCHAR(45) NOT NULL,
  `cep_pessoa` VARCHAR(45) NOT NULL,
  `senha_pessoa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpessoa`))
;


-- -----------------------------------------------------
-- Table `nursepi`.`Enfermeiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nursepi`.`Enfermeiro` (
  `matricula_enfermeiro` INT NOT NULL AUTO_INCREMENT,
  `data_nascimento_enfermeiro` DATE NOT NULL,
  `cpf_enfermeiro` VARCHAR(45) NOT NULL,
  `sexo_enfermeiro` CHAR NOT NULL,
  `Pessoa_idpessoa` INT NOT NULL,
  PRIMARY KEY (`matricula_enfermeiro`, `Pessoa_idpessoa`),  
  CONSTRAINT `fk_Enfermeiro_Pessoa`
    FOREIGN KEY (`Pessoa_idpessoa`)
    REFERENCES `nursepi`.`Pessoa` (`idpessoa`)    
    )
;


-- -----------------------------------------------------
-- Table `nursepi`.`EstabelecimentoDeSaude`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nursepi`.`EstabelecimentoDeSaude` (
  `cnpj_estabelecimento_de_saude` INT NOT NULL AUTO_INCREMENT,
  `Pessoa_idpessoa` INT NOT NULL,
  `tipo_estabelecimento_de_saude` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cnpj_estabelecimento_de_saude`, `Pessoa_idpessoa`),
  CONSTRAINT `fk_EstabelecimentoDeSaude_Pessoa1`
    FOREIGN KEY (`Pessoa_idpessoa`)
    REFERENCES `nursepi`.`Pessoa` (`idpessoa`)    
    )
;


-- -----------------------------------------------------
-- Table `nursepi`.`ProdutoEpi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nursepi`.`ProdutoEpi` (
  `codigo_produto_epi` INT NOT NULL AUTO_INCREMENT,
  `tamanho_produto_epi` VARCHAR(45) NOT NULL,
  `quantidade_produto_epi` INT NOT NULL,
  `tipo_produto_epi` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_produto_epi`))
;


-- -----------------------------------------------------
-- Table `nursepi`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nursepi`.`Pedido` (
  `codigo_pedido` INT NOT NULL AUTO_INCREMENT,
  `data_solicitacao_pedido` DATE NOT NULL,
  `status_pedido` BIT NOT NULL,
  `Enfermeiro_matricula_enfermeiro` INT NOT NULL,
  `Enfermeiro_Pessoa_idpessoa` INT NOT NULL,
  PRIMARY KEY (`codigo_pedido`, `Enfermeiro_matricula_enfermeiro`, `Enfermeiro_Pessoa_idpessoa`),  
  CONSTRAINT `fk_Pedido_Enfermeiro1`
    FOREIGN KEY (`Enfermeiro_matricula_enfermeiro` , `Enfermeiro_Pessoa_idpessoa`)
    REFERENCES `nursepi`.`Enfermeiro` (`matricula_enfermeiro` , `Pessoa_idpessoa`)    
    )
;


-- -----------------------------------------------------
-- Table `nursepi`.`Pedido_has_ProdutoEpi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nursepi`.`Pedido_has_ProdutoEpi` (
  `Pedido_codigo_pedido` INT NOT NULL,
  `Pedido_Enfermeiro_matricula_enfermeiro` INT NOT NULL,
  `Pedido_Enfermeiro_Pessoa_idpessoa` INT NOT NULL,
  `ProdutoEpi_codigo_produto_epi` INT NOT NULL,
  PRIMARY KEY (`Pedido_codigo_pedido`, `Pedido_Enfermeiro_matricula_enfermeiro`, `Pedido_Enfermeiro_Pessoa_idpessoa`, `ProdutoEpi_codigo_produto_epi`),

  CONSTRAINT `fk_Pedido_has_ProdutoEpi_Pedido1`
    FOREIGN KEY (`Pedido_codigo_pedido` , `Pedido_Enfermeiro_matricula_enfermeiro` , `Pedido_Enfermeiro_Pessoa_idpessoa`)
    REFERENCES `nursepi`.`Pedido` (`codigo_pedido` , `Enfermeiro_matricula_enfermeiro` , `Enfermeiro_Pessoa_idpessoa`),
  CONSTRAINT `fk_Pedido_has_ProdutoEpi_ProdutoEpi1`
    FOREIGN KEY (`ProdutoEpi_codigo_produto_epi`)
    REFERENCES `nursepi`.`ProdutoEpi` (`codigo_produto_epi`)
    )
;


-- -----------------------------------------------------
-- Table `nursepi`.`EstabelecimentoDeSaude_has_Enfermeiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nursepi`.`EstabelecimentoDeSaude_has_Enfermeiro` (
  `EstabelecimentoDeSaude_cnpj_estabelecimento_de_saude` INT NOT NULL,
  `EstabelecimentoDeSaude_Pessoa_idpessoa` INT NOT NULL,
  `Enfermeiro_matricula_enfermeiro` INT NOT NULL,
  `Enfermeiro_Pessoa_idpessoa` INT NOT NULL,
  PRIMARY KEY (`EstabelecimentoDeSaude_cnpj_estabelecimento_de_saude`, `EstabelecimentoDeSaude_Pessoa_idpessoa`, `Enfermeiro_matricula_enfermeiro`, `Enfermeiro_Pessoa_idpessoa`),
  CONSTRAINT `fk_EstabelecimentoDeSaude_has_Enfermeiro_EstabelecimentoDeSau1`
    FOREIGN KEY (`EstabelecimentoDeSaude_cnpj_estabelecimento_de_saude` , `EstabelecimentoDeSaude_Pessoa_idpessoa`)
    REFERENCES `nursepi`.`EstabelecimentoDeSaude` (`cnpj_estabelecimento_de_saude` , `Pessoa_idpessoa`),    
  CONSTRAINT `fk_EstabelecimentoDeSaude_has_Enfermeiro_Enfermeiro1`
    FOREIGN KEY (`Enfermeiro_matricula_enfermeiro` , `Enfermeiro_Pessoa_idpessoa`)
    REFERENCES `nursepi`.`Enfermeiro` (`matricula_enfermeiro` , `Pessoa_idpessoa`)
    )
;

select codigo_pedido, status_pedido, Enfermeiro_matricula_enfermeiro from pedido;


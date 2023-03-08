CREATE TABLE `Ordenes` (
	`ordenesId` BIGINT NOT NULL AUTO_INCREMENT,
	`clienteId` BIGINT,
	`productoId` BIGINT,
	`precioProducto` DOUBLE(10),
	`cantProducto` INT(5),
	PRIMARY KEY (`ordenesId`)
);
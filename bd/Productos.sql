CREATE TABLE `Productos` (
	`productoId` BIGINT NOT NULL AUTO_INCREMENT,
	`nomProducto` VARCHAR(200),
	`mcaProducto` VARCHAR(200),
	`precioProducto` DOUBLE(10),
	PRIMARY KEY (`productoId`)
);
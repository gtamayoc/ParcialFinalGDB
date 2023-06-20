from datetime import datetime

class Document:
    def __init__(self, _id, usuario_id, nombre, apellido, correo_electronico, acceso):
        self._id = _id
        self.usuario_id = usuario_id
        self.nombre = nombre
        self.apellido = apellido
        self.correo_electronico = correo_electronico
        self.acceso = acceso

class Acceso:
    def __init__(self, fecha, direccion_ip, navegador, sistema_operativo, navegado):
        self.fecha = datetime.strptime(fecha, "%Y-%m-%dT%H:%M:%S.%f%z")
        self.direccion_ip = direccion_ip
        self.navegador = navegador
        self.sistema_operativo = sistema_operativo
        self.navegado = navegado
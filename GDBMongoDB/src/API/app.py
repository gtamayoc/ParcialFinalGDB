from flask import Flask, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

class Document:
    def __init__(self, _id, usuario_id, nombre, apellido, correo_electronico, acceso):
        self._id = _id
        self.usuario_id = usuario_id
        self.nombre = nombre
        self.apellido = apellido
        self.correo_electronico = correo_electronico
        self.acceso = acceso

    def to_dict(self):
        return {
            "_id": str(self._id),
            "usuario_id": self.usuario_id,
            "nombre": self.nombre,
            "apellido": self.apellido,
            "correo_electronico": self.correo_electronico,
            "acceso": self.acceso.to_dict() if self.acceso else None
        }

class Acceso:
    def __init__(self, fecha, direccion_ip, navegador, sistema_operativo, navegado):
        self.fecha = fecha
        self.direccion_ip = direccion_ip
        self.navegador = navegador
        self.sistema_operativo = sistema_operativo
        self.navegado = navegado

    def to_dict(self):
        return {
            "fecha": self.fecha,
            "direccion_ip": self.direccion_ip,
            "navegador": self.navegador,
            "sistema_operativo": self.sistema_operativo,
            "navegado": self.navegado
        }

def connect_to_mongodb(uri):
    client = MongoClient(uri)
    db = client["parcialGDB"]
    collection = db["usuarios"]
    return collection

@app.route('/documents')
def get_all_documents():
    uri = request.args.get('uri')
    collection = connect_to_mongodb(uri)
    documents = []
    for doc in collection.find():
        _id = doc["_id"]
        usuario_id = doc["Document"].get("usuario_id")
        nombre = doc["Document"].get("nombre")
        apellido = doc["Document"].get("apellido")
        correo_electronico = doc["Document"].get("correo_electronico")
        acceso_data = doc["Document"].get("acceso")
        if acceso_data:
            acceso = Acceso(
                fecha=acceso_data.get("fecha"),
                direccion_ip=acceso_data.get("direccion_ip"),
                navegador=acceso_data.get("navegador"),
                sistema_operativo=acceso_data.get("sistema_operativo"),
                navegado=acceso_data.get("navegado")
            )
        else:
            acceso = None
        document = Document(_id, usuario_id, nombre, apellido, correo_electronico, acceso)
        documents.append(document.to_dict())
    return jsonify(documents)

if __name__ == '__main__':
    app.run(debug=True)
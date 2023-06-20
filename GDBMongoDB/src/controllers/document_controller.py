from models.document import Document, Acceso
from pymongo import MongoClient

def connect_to_mongodb(uri):
    client = MongoClient(uri)
    db = client["pacialGDB"]
    collection = db["usuarios"]
    return collection

def create_document(uri, _id, usuario_id, nombre, apellido, correo_electronico, fecha, direccion_ip, navegador, sistema_operativo, navegado):
    collection = connect_to_mongodb(uri)
    acceso = Acceso(fecha, direccion_ip, navegador, sistema_operativo, navegado)
    document = Document(_id, usuario_id, nombre, apellido, correo_electronico, acceso)
    document_dict = document.__dict__
    collection.insert_one(document_dict)

def get_all_documents(uri):
    collection = connect_to_mongodb(uri)
    documents = []
    for doc in collection.find():
        acceso_dict = doc["acceso"]
        acceso = Acceso(acceso_dict["fecha"], acceso_dict["direccion_ip"], acceso_dict["navegador"], acceso_dict["sistema_operativo"], acceso_dict["navegado"])
        document = Document(
            str(doc["_id"]),  # Convertir ObjectId a cadena
            doc["usuario_id"],
            doc["nombre"],
            doc["apellido"],
            doc["correo_electronico"],
            acceso,
        )
        documents.append(document)
        documents.append(document)
    return documents

def get_document(uri, _id):
    collection = connect_to_mongodb(uri)
    document_dict = collection.find_one({"_id": _id})
    if document_dict:
        acceso_dict = document_dict["acceso"]
        acceso = Acceso(acceso_dict["fecha"], acceso_dict["direccion_ip"], acceso_dict["navegador"], acceso_dict["sistema_operativo"], acceso_dict["navegado"])
        document = Document(document_dict["_id"], document_dict["usuario_id"], document_dict["nombre"], document_dict["apellido"], document_dict["correo_electronico"], acceso)
        return document
    else:
        return None

def update_document(uri, _id, usuario_id, nombre, apellido, correo_electronico, fecha, direccion_ip, navegador, sistema_operativo, navegado):
    collection = connect_to_mongodb(uri)
    acceso = Acceso(fecha, direccion_ip, navegador, sistema_operativo, navegado)
    document = Document(_id, usuario_id, nombre, apellido, correo_electronico, acceso)
    document_dict = document.__dict__
    collection.update_one({"_id": _id}, {"$set": document_dict})

def delete_document(uri, _id):
    collection = connect_to_mongodb(uri)
    collection.delete_one({"_id": _id})

def request_mongodb_connection_details():
    uri = input("Ingrese el URI de MongoDB: ")
    return uri
from flask import Blueprint, request, jsonify
from controllers.document_controller import (
    create_document, get_all_documents, get_document, update_document, delete_document
)

document_bp = Blueprint("document", __name__)

@document_bp.route('/documents', methods=['POST'])
def create_document_view():
    data = request.get_json()
    create_document(data["uri"], data["_id"], data["usuario_id"], data["nombre"], data["apellido"], data["correo_electronico"], data["acceso"]["fecha"], data["acceso"]["direccion_ip"], data["acceso"]["navegador"], data["acceso"]["sistema_operativo"], data["acceso"]["navegado"])
    return jsonify({'message': 'Documento creado correctamente'})

@document_bp.route('/documents', methods=['GET'])
def get_all_documents_view():
    uri = request.args.get('uri')
    documents = get_all_documents(uri)
    document_list = []
    for doc in documents:
        doc_dict = doc.__dict__
        doc_dict['acceso'] = doc_dict['acceso'].__dict__  # Serializar el objeto Acceso
        document_list.append(doc_dict)
    return jsonify({'documents': document_list})

@document_bp.route('/documents/<id>', methods=['GET'])
def get_document_view(id):
    uri = request.args.get('uri')
    document = get_document(uri, id)
    if document:
        return jsonify({'document': document.__dict__})
    else:
        return jsonify({'message': 'Documento no encontrado'})

@document_bp.route('/documents/<id>', methods=['PUT'])
def update_document_view(id):
    data = request.get_json()
    update_document(data["uri"], id, data["usuario_id"], data["nombre"], data["apellido"], data["correo_electronico"], data["acceso"]["fecha"], data["acceso"]["direccion_ip"], data["acceso"]["navegador"], data["acceso"]["sistema_operativo"], data["acceso"]["navegado"])
    return jsonify({'message': 'Documento actualizado correctamente'})

@document_bp.route('/documents/<id>', methods=['DELETE'])
def delete_document_view(id):
    uri = request.args.get('uri')
    delete_document(uri, id)
    return jsonify({'message': 'Documento eliminado correctamente'})
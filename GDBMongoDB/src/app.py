from flask import Flask
from views.document_view import document_bp
from controllers.document_controller import request_mongodb_connection_details

app = Flask(__name__)
app.register_blueprint(document_bp)

# Obtener la dirección de MongoDB del usuario
uri = request_mongodb_connection_details()

if __name__ == '__main__':
    app.run()    
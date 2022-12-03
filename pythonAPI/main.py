import json

import flask
from flask import request, jsonify, Response
from transformers import pipeline
import spacy

app = flask.Flask(__name__)
app.config["DEBUG"] = True
huggingface = pipeline("ner")

spacy = spacy.load("en_ner_bionlp13cg_md")


@app.route('/huggingface', methods=['GET'])
def get_annotations_HuggingFace():
    if 'text' in request.args:
        text = request.args['text']
    else:
        return "Error: No text field provided. Please specify a text."
    sequence = huggingface(text)
    return str(sequence)


@app.route('/spacy', methods=['GET'])
def get_annotations_Spacy():
    if 'text' in request.args:
        text = request.args['text']
    else:
        return "Error: No text field provided. Please specify a text."

    doc = spacy(text)
    sequence = []
    for ent in doc.ents:
        annotation = {
            "text": ent.text,
            "start": ent.start_char,
            "end": ent.end_char,
            "type": ent.label_
        }
        sequence.append(annotation)

    return str(sequence)


app.run()

"""Populate all the tables with mock data for Testing"""

import sys, os
# Add the application folder to path
sys.path.append(os.path.join(os.path.dirname(__file__), '..'))

import datetime
from flask import Flask, jsonify
from models import db, Student, Administrator, Submission, Assignment, Group

app = Flask(__name__)
app.config['SECRET_KEY']='thisissecretkey'
app.config['SQLALCHEMY_DATABASE_URI']='sqlite:///../database.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS']=False
db.init_app(app)


with app.app_context():
    # Administrator Records
    a1 = Administrator(first_name="Hanif", last_name="Ali", email="hanif@abc.com", password="random")
    a2 = Administrator(first_name="Hania", last_name="Aslam", email="haniaaslam@abc.com", password="random")
    db.session.add(a1)
    db.session.add(a2)


    # Group Records
    g1 = Group(name="BESE10B", administrator=a1)
    g2 = Group(name="CESE10C", administrator=a2)
    db.session.add(g1)
    db.session.add(g2)

    # Student Records
    s1 = Student(first_name="Saboor", last_name="Qaiser", cms_id=28326, 
                    email="saboor@abc.com", password="random", group=g1)
    s2 = Student(first_name="Hanif", last_name="Ali", cms_id=28327, 
                    email="hanif@abc.com", password="random", group=g1)
    s3 = Student(first_name="Maaz", last_name="Rana", cms_id=28328, 
                    email="rana@abc.com", password="random", group=g2)
    s4 = Student(first_name="Fatima", last_name="Zahra", cms_id=28329, 
                    email="fatimag@abc.com", password="random", group=g2)
    db.session.add(s1)
    db.session.add(s2)
    db.session.add(s3)
    db.session.add(s4)                
    s1 = Student(first_name="Fahad", last_name="Ali", cms_id=28330, 
                    email="fahad@abc.com", password="random", group=g2)
    s2 = Student(first_name="Ahmed", last_name="1", cms_id=28331, 
                    email="ahmed1@abc.com", password="random", group=g2)
    s3 = Student(first_name="Ahmed", last_name="2", cms_id=28333, 
                    email="ahmed2@abc.com", password="random", group=g2)
    s4 = Student(first_name="Waniya", last_name="Jalal", cms_id=28332, 
    
                    email="waniya@abc.com", password="random", group=g2)
    db.session.add(s1)
    db.session.add(s2)
    db.session.add(s3)
    db.session.add(s4)
    
    
    s1 = Student(first_name="Maheen", last_name="NIsar", cms_id=28334, 
                    email="maheen@abc.com", password="random", group=g2)
    s2 = Student(first_name="mahina", last_name="sheikh", cms_id=28337, 
                    email="mahina@abc.com", password="random", group=g2)
    s3 = Student(first_name="Saqib", last_name="Rasheed", cms_id=28335, 
                    email="saqib@abc.com", password="random", group=g2)
    s4 = Student(first_name="Saad", last_name="rehman", cms_id=28336, 
                    email="saad@abc.com", password="random", group=g2)                                
    db.session.add(s1)
    db.session.add(s2)
    db.session.add(s3)
    db.session.add(s4)

    s1 = Student(first_name="Hassan", last_name="Abid", cms_id=291905, 
                    email="hassan@abc.com", password="random", group=g2)
    s2 = Student(first_name="Hammad", last_name="sheikh", cms_id=291906, 
                    email="hammad@abc.com", password="random", group=g2)
    s3 = Student(first_name="Talha", last_name="Mujahid", cms_id=291907, 
                    email="talha@abc.com", password="random", group=g2)
    s4 = Student(first_name="Altaf", last_name="Hussain", cms_id=291908, 
                    email="altaf@abc.com", password="random", group=g2)                                
    db.session.add(s1)
    db.session.add(s2)
    db.session.add(s3)
    db.session.add(s4)




    db.session.commit()
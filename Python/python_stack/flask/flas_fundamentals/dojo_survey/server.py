from flask import Flask, render_template, request
app = Flask(__name__)

@app.route('/')
def index():
    return render_template("index.html")

@app.route('/result', methods=['POST'])
def result():
    name = request.form['name']
    dojo_location = request.form['location']
    favourite_location = request.form['fav-lang']
    comment = request.form['comments']
    experience = request.form['answer']
    language = request.form.getlist('Lang')
    print(experience)
    print(language)
    return render_template("result.html", name=name, dojo_location=dojo_location,fav_lang=favourite_location, comment=comment,exp=experience,lan=language)

if __name__ == '__main__':
    app.run(debug=True)
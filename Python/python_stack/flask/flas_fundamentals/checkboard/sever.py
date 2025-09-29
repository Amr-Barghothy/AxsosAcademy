from flask import Flask, render_template

app = Flask(__name__)


@app.route('/')
def index():
    return render_template("index.html", rows=8, cols=8,color1 = None, color2 = None)


@app.route('/<int:x>')
def rows(x):
    return render_template("index.html", rows=x, cols=8 ,color1 = None, color2 = None)


@app.route('/<int:x>/<int:y>')
def row_cols(x, y):
    return render_template("index.html", rows=x, cols=y ,color1 = None, color2 = None)

@app.route('/<int:x>/<int:y>/<color1>/<color2>')
def coloring(x, y,color1, color2):
    return render_template("index.html", rows=x, cols=y, color1=color1, color2=color2)


if __name__ == '__main__':
    app.run(debug=True)

from django.shortcuts import render, redirect
import random
from time import gmtime, strftime

context = {
    "num": 0
}


# Create your views here.
def index( request ):
    return render(request, 'index.html', context)


def gold( request ):
    if not 'activity' in request.session:
        request.session['activity'] = []
    time = strftime(" %B %d %Y %H:%M %p", gmtime())
    num = random.randint(10, 20)
    if "farm" in request.POST:
        request.session["activity"].append(f"you entered a farm and earned {num} gold. ({time})")
        context["num"] += num
    elif "cave" in request.POST:
        request.session['activity'].append(f"you entered a cave and earned {num} gold. ({time})")
        context["num"] += num
    elif "house" in request.POST:
        request.session['activity'].append(f"you entered a house and earned {num} gold. ({time})")
        context["num"] += num
    else:
        num = random.randint(0, 50)
        win = random.randint(0, 1)
        if win == 1:
            request.session['activity'].append(f"you completed a quest and earned {num} gold. ({time})")
        else:
            request.session['activity'].append(f"you failed a quest and lost {num} gold Ouch. ({time})")
            num *= -1
        context["num"] += num

    request.session.modified = True
    return redirect("/")

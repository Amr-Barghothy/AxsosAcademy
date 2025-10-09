from django.shortcuts import render, redirect
from .models import *

from . import team_maker


def index(request):
    context = {
        "baseballs": get_all_baseball(),
        "womens": get_all_women(),
        "hockeys" : get_any_hockey(),
        "footballs": get_not_football(),
        "conferences": get_conferences(),
        "atlantics": get_all_atlantic(),
        "dallas": geet_teams_in_dalas(),
        "raptors": get_raptors(),
        "cities": get_not_city(),
        "T" : teams_with_t(),
        "sorted_asc": asc_teams(),
        "sorted_desc": desc_teams(),
        "coopers" : player_with_name_cooper(),
        "joshuas": player_with_name_joshua(),
        "without_joshua": cooper_without_joshua(),
        "alexs" : alexander_or_wyatt()

    }
    return render(request, "leagues/index.html", context)


def make_data(request):
    team_maker.gen_leagues(10)
    team_maker.gen_teams(50)
    team_maker.gen_players(200)

    return redirect("index")

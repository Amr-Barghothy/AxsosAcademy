from django.shortcuts import render, redirect
from .models import *

from . import team_maker


def index(request):
    context = {
        "all_teams_atlantic": all_teams_in_atlantic(),
        "all_players_in_penguin": all_player_in_penguin(),
        "all_current_players_in_international_collegiate_baseball_conference": all_current_players_in_international_collegiate_baseball_conference(),
        "all_players_in_american_conference_of_amateur": all_player_american_conference_of_amateur(),
        "all_football_players": all_football_players(),
        "all_teams_with_sophia": all_teams_with_sophia(),
        "all_leagues_with_sophia": all_league_with_sophia(),
        "all_flores_not_in_washington": all_flores_not_in_washington(),
        "all_teams_samuel_evans_played_with": all_teams_have_samuel(),
        "all_players_with_manitoba_tigercats": all_players_with_manitoba(),
        "all_players_not_in_vikings_anymore": all_players_not_in_vikings_anymore(),
        "all_teams_with_jacob_before_colts": all_teams_with_jacob_before_colts(),
        "all_joshuas_in_atlantic_federation": all_joshuas_in_atlantic_federation(),
        "all_teams_with_12_or_more_players": all_teams_with_12_or_more_players(),
        "all_players_and_team_counts": all_players_and_team_counts(),
    }
    return render(request, "leagues/index.html", context)


def make_data(request):
    team_maker.gen_leagues(10)
    team_maker.gen_teams(50)
    team_maker.gen_players(200)

    return redirect("index")

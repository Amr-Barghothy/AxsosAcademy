from django.db import models
from django.db.models import Q


class League(models.Model):
    name = models.CharField(max_length=50)
    sport = models.CharField(max_length=15)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


class Team(models.Model):
    location = models.CharField(max_length=50)
    team_name = models.CharField(max_length=50)
    league = models.ForeignKey(League, related_name="teams", on_delete=models.CASCADE)


class Player(models.Model):
    first_name = models.CharField(max_length=15)
    last_name = models.CharField(max_length=15)
    curr_team = models.ForeignKey(Team, related_name="curr_players", on_delete=models.CASCADE)
    all_teams = models.ManyToManyField(Team, related_name="all_players")


def get_all_baseball():
    return League.objects.filter(sport__exact="Baseball")


def get_all_women():
    return League.objects.filter(name__contains="Womens")


def get_any_hockey():
    return League.objects.filter(sport__contains="Hockey")


def get_not_football():
    return League.objects.exclude(sport__contains="Football")


def get_conferences():
    return League.objects.filter(name__contains="Conference")


def get_all_atlantic():
    return League.objects.filter(name__contains="Atlantic")


def geet_teams_in_dalas():
    return Team.objects.filter(location__exact="Dallas")


def get_raptors():
    return Team.objects.filter(team_name__contains="Raptors")


def get_not_city():
    return Team.objects.exclude(location__contains="City")


def teams_with_t():
    return Team.objects.filter(team_name__startswith="T")


def asc_teams():
    return Team.objects.all().order_by("location")


def desc_teams():
    return Team.objects.all().order_by("-team_name")


def player_with_name_cooper():
    return Player.objects.filter(last_name__contains="Cooper")


def player_with_name_joshua():
    return Player.objects.filter(first_name__contains="Joshua")


def cooper_without_joshua():
    return Player.objects.filter(last_name__contains="Cooper").exclude(first_name__contains="Joshua")


def alexander_or_wyatt():
    return Player.objects.filter(Q(first_name__contains="Alexander") | Q(first_name__contains="Wyatt"))

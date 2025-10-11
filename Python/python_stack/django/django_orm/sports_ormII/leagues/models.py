from django.db import models
from django.db.models import Q, Count


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


def all_teams_in_atlantic():
    return Team.objects.filter(league__name__icontains="atlantic").order_by(
        "league__name")


def all_player_in_penguin():
    return Player.objects.filter(curr_team__team_name__icontains="penguin", curr_team__location__icontains="boston")


def all_current_players_in_international_collegiate_baseball_conference():
    return Player.objects.filter(curr_team__league__name__icontains="International Collegiate Baseball Conference",
                                 curr_team__league__sport__icontains="baseball")


def all_player_american_conference_of_amateur():
    return Player.objects.filter(curr_team__league__name__icontains="American Conference of Amateur Football",
                                 curr_team__league__sport__icontains="football", last_name__icontains="Lopez")


def all_football_players():
    return Player.objects.filter(all_teams__league__sport__icontains="football")


def all_teams_with_sophia():
    return Team.objects.filter(curr_players__first_name__icontains="Sophia")


def all_league_with_sophia():
    return League.objects.filter(teams__curr_players__first_name__icontains="Sophia")


def all_flores_not_in_washington():
    return Player.objects.filter(last_name="Flores").exclude(curr_team__location__icontains="Washington",
                                                             curr_team__team_name__icontains="Roughriders")


def all_teams_have_samuel():
    return Team.objects.filter(all_players__first_name__icontains="Samuel", all_players__last_name__icontains="Evans")


def all_players_with_manitoba():
    return Player.objects.filter(all_teams__team_name__icontains="tiger-cats",
                                 all_teams__location__icontains="Manitoba")


def all_players_not_in_vikings_anymore():
    return Player.objects.filter(all_teams__team_name__icontains="vikings",
                                 all_teams__location__icontains="Wichita").exclude(
        curr_team__team_name__icontains="vikings", curr_team__location__icontains="Wichita")


def all_teams_with_jacob_before_colts():
    return Team.objects.filter(all_players__first_name__icontains="Jacob",
                               all_players__last_name__icontains="Gray").exclude(location__icontains="Oregon",
                                                                                 team_name__icontains="Colts")


def all_joshuas_in_atlantic_federation():
    return Player.objects.filter(
        first_name__icontains="Joshua",
        all_teams__league__name__icontains="Atlantic Federation of Amateur Baseball Players")


def all_teams_with_12_or_more_players():
    return Team.objects.annotate(num_players=Count('all_players')).filter(num_players__gte=12)


def all_players_and_team_counts():
    player = Player.objects.annotate(num_teams=Count('all_teams')).order_by('num_teams')
    return player

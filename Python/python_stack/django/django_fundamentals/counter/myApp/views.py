from django.shortcuts import render,redirect


# Create your views here.
def index( request ):
    if not 'num' in request.session:
        request.session['num'] = 0
    if not 'custom' in request.session:
        request.session['custom'] = 0
    request.session['num'] = request.session['num'] + 1
    return render(request, 'index.html')


def del_session(request):
    del request.session['num']
    del request.session['custom']
    return redirect('/')

def inc_by_two( request ):
    request.session['num'] += 1
    return redirect('/')

def custom_inc( request ):
    num = request.POST['custom_num']
    request.session['custom'] += int(num)
    return redirect('/')
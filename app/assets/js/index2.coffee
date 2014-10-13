$ ->
  $.get "/persons", (persons) ->
    $.each persons, (index, person) ->
      $('#personss').append $('<li>').text person.name

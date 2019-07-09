/* jshint esversion: 6 */
/* jshint browser: true */
$(() => {
    "use strict";

    const maze = $('#maze');
    const boundary = $('.boundary');
    const start = $('#start');
    const end = $('#end');
    const status = $('#status');

    const game = {
        playing: false,
        lose: () => {
            if(!game.playing) return;

            game.playing = false;
            boundary.addClass('youlose');
            status.text('You lose');
            $('#imgStatus').attr('src','images/loser.jpg');
        },
        start: () => {
            boundary.removeClass('youlose');
            status.text('You are playing, enjoy!!!!!');
            game.playing = true;
            $('#imgStatus').attr('src','images/maze06.gif');
        },
        end: () => {
            if(!game.playing) return;
            if(boundary.hasClass('youlose')) return;

            game.playing = false;
            status.text('You win');
            $('#imgStatus').attr('src','images/winner.jpg');
        }
    };

    maze.mouseleave(game.lose);
    boundary.mouseover(game.lose);
    start.click(game.start);
    end.mouseover(game.end);

    
});


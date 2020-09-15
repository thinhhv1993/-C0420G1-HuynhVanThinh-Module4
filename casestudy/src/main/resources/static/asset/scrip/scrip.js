// document.getElementById("delete").onclick = function() {myFunction1()};

// $(#delete).on("click", function () {
//     var deleteLinks = document.querySelectorAll('.delete');
//     for (var i = 0; i < deleteLinks.length; i++) {
//         deleteLinks[i].addEventListener('click', function(event) {
//             event.preventDefault();
//             var choice = confirm(this.getAttribute('data-confirm'));
//             if (choice) {
//                 window.location.href = this.getAttribute('href');
//             }
//         });
//     }
// })
(function () {
    'use strict';
    window.addEventListener('load', function () {
        var deleteLinks = document.querySelectorAll('.delete');
        for (var i = 0; i < deleteLinks.length; i++) {
            deleteLinks[i].addEventListener('click', function(event) {
                event.preventDefault();
                var choice = confirm(this.getAttribute('data-confirm'));
                if (choice) {
                    window.location.href = this.getAttribute('href');
                }
            });
        }
    }, false);
})();
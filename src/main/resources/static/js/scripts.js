$(document).ready(function() {
    // Example effect: Highlight table row on hover
    $("table tbody tr").hover(
        function() {
            $(this).css("background-color", "#f5f5f5");
        },
        function() {
            $(this).css("background-color", "white");
        }
    );

    // Fade in the container
    $(".container").hide().fadeIn(1000);

    // Button hover effect
    $(".button").hover(
        function() {
            $(this).css("background-color", "#0056b3");
        },
        function() {
            $(this).css("background-color", "#007bff");
        }
    );
});

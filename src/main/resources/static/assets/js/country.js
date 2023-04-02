$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/countries/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (country, status){
            $('#idEdit').val(country.id);
            $('#codeEdit').val(country.code);
            $('#capitalEdit').val(country.capital);
            $('#descriptionEdit').val(country.description);
            $('#nationalityEdit').val(country.nationality);
            $('#continentEdit').val(country.continent);
        });

        $('#editModal').modal('show');
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/countries/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
        });


});






// $('document').ready(function (){
//     $('table #editButton').on('click', function (event){
//         event.preventDefault();
//
//         // /countries/findById/?id=1
//
//         var href = $(this).attr('href'); //this is equal now to the url manifest when the button is clicked
//         $.get(href, function (country, status){
//             $('#idEdit').val(country.id);
//             $('#codeEdit').val(country.code);
//             $('#capitalEdit').val(country.capital);
//             $('#descriptionEdit').val(country.description);
//             $('#nationalityEdit').val(country.nationality);
//             $('#continentEdit').val(country.continent);
//         });
//         $('#editModal').modal('show');
//     });
// });
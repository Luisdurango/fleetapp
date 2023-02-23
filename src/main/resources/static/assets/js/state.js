$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/state/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (state, status) {
            $('#idEdit').val(state.id);
            $('#ddlCountryEdit').val(state.countryid);
            $('#nameEdit').val(state.name);
            $('#capitalEdit').val(state.capital);
            $('#detailsEdit').val(state.details);

        });

        $('#editModal').modal('show');
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/state/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });


});
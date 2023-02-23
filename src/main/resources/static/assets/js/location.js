$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/location/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (location, status){
            $('#idEdit').val(location.id);
            $('#cityEdit').val(location.city);
            $('#ddlCountryEdit').val(location.countryid);
            $('#ddlStateEdit').val(location.stateid);
            $('#descriptionEdit').val(location.description);
            $('#addressEdit').val(location.address);
            $('#detailsEdit').val(location.details);
        });

        $('#editModal').modal('show');
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/location/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });


});
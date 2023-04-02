$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/client/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (client, status){
            $('#idEdit').val(client.id);
            $('#nameEdit').val(client.name);
            $('#addressEdit').val(client.address);
            $('#stateEdit').val(client.stateid);
            $('#countryEdit').val(client.countryid);
            $('#cityEdit').val(client.city);
            $('#phoneEdit').val(client.phone);
            $('#mobileEdit').val(client.mobile);
            $('#emailEdit').val(client.email);
            $('#websiteEdit').val(client.website);

        });

        $('#editModal').modal('show');
    });

    // $('table #deleteButton').on('click', function (event){
    //     //event.preventDefault();
    //     var id = $(this).data('id');
    //     var url = '/client/delete?id=' + id;
    //     $('#confirmDeleteButton').attr('href',url)
    //
    //
    //
    //     $('#deleteModal').modal('show');
    // });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/client/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });


});
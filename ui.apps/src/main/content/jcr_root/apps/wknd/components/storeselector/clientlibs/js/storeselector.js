$(document).ready(function() {

    const GATEWAY_ENDPOINT = '/content/dam/wknd-shared/en/stores-list.infinity.json';
    const STORE_ENDPOINT = '/content/dam/wknd-shared/en/tanishq-stores.infinity.json';
    let city_stores;
    var stores;
    let cityList = [];
    let storeList;
    var settings = {
        "url": GATEWAY_ENDPOINT,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        }
    };

    var settingsStore = {
        "url": STORE_ENDPOINT,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        }
    };

    $.ajax(settings).done(function(response) {
        city_stores = jQuery.parseJSON(response["jcr:content"].data.master.cityStores);
        console.log(city_stores);
        Object.keys(city_stores).forEach(function(key) {
            $('#citySelect').append($('<option></option>').val(key).html(key));
            cityList.push(key);
        });
    });

    $.ajax(settingsStore).done(function(response) {
        stores = response;
        console.log(stores);
    });

    $(document).on('change', '#citySelect', function() {
        var value = $('#citySelect').val();
        console.log("City Changed - " + value + " - Stores - " + city_stores[value]);
        storeList = city_stores[value];
        $('#storeSelect').html($('<option></option>').val(null).html("Choose Store"))
        for (storeId in storeList) {
            var id = storeList[storeId];
            var tempStore = stores[id];
            var data = tempStore["jcr:content"].data.master;
            console.log(data);
            $('#storeSelect').append($('<option></option>').val(id).html(data.storeName));
        }
    });
});
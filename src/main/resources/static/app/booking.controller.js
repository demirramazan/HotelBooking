(function () {
    'use strict';
    angular
        .module('app')
        .controller('BookingController', BookingController);

    BookingController.$inject = ['$http'];

    function BookingController($http) {
        var vm = this;

        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/bookings/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookings = response.data;
            });
        }

        function getAffordable(){
            var url = "/bookings/affordable/" + 100;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookings = response.data;
            });
        }

        function deleteBooking(id){
            var url = "/bookings/delete/" + id;
            $http.post(url).then(function(response){
                vm.bookings = response.data;
            });
        }
    }
    // angular.module('app').controller('HotelControllerRepoSample', HotelControllerRepoSample);
    // HotelControllerRepoSample.$inject = ['$http'];
    //
    // function HotelControllerRepoSample($http) {
    //     var vm = this;
    //
    //     var bookings = [];
    //     var getAll=getAll;
    //     var getAffordable=getAffordable;
    //     var deleteBooking=deleteBooking;
    //
    //     init();
    //
    //     function init() {
    //         getAll();
    //     }
    //
    //     function getAll() {
    //         var url = "/booking/alls";
    //         var bookingPromise = $http.get(url);
    //         bookingPromise.then(function (response) {
    //             vm.bookings = response.data;
    //         });
    //     }
    //
    //     function getAffordable() {
    //         var url = "/booking/affordables/" + 100;
    //         var bookingPromise = $http.get(url);
    //         bookingPromise.then(function (response) {
    //             vm.bookings = response.data;
    //         });
    //
    //         function  deleteBooking(id) {
    //             var url = "/booking/remove/" + id;
    //             var bookingPromise = $http.deleteRow(url);
    //             bookingPromise.then(function (response) {
    //                 vm.bookings = response.data;
    //             });
    //         }
    //     }
    // }
})();
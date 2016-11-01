/**
 * Created by Yang on 2016/8/4.
 */
angular.module('Store',[])
    .controller('storeCtrl',['$http','$scope',function ($http,$scope) {
    $http.get('products.json').success(function (data) {
        $scope.products=data;
    });
        
        $scope.addItem = function (name,description,price) {
            var item={
                name:name,
                description:description,
                price:price
                
            };

            $scope.products=$scope.products.concat(item);
            $scope.name="";
            $scope.description="";
            $scope.price="";            
            console.log($scope.products);
        };

        $scope.deleteItem =function (name) {

            $scope.products = $scope.products.filter(function (products) {
                return products.name!=name;
            });
        }
}]);
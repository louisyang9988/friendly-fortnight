var f = (funciton(){
    return {
        foo : "bar",
        moo : function(callback){
            callback.call(this);
        }
    }
})();

f.moo(function () {alert(this.foo)
    
});

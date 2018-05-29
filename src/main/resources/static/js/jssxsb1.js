var chushi = "onedadadsfsefed";

function gettext(tet) {
    tet = "它毛的方dsa法" + tet;
    return tet;
}
function Cat(name,age) {
    this.name = name;
    this.age = age;
    this.getName = function() {
        return this.name;
    };
    this.getAge = function() {
        return this.age;
    }
}
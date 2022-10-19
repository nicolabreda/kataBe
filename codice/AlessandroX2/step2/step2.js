var Poggetto = {
    0: '0000',
    1: '0001',
    2: '0010',
    3: '0011',
    4: '0100',
    5: '0101',
    6: '0110',
    7: '0111',
    8: '1000',
    9: '1001',
    A: '1010',
    B: '1011',
    C: '1100',
    D: '1101',
    E: '1110',
    F: '1111'
}

var stringaTotale = '';
var step2 = function (esa) {
    for (var i = 0; i < esa.length; i++) {
        stringaTotale += Poggetto[esa[i]];
    }
    console.log(stringaTotale);
    var version=stringaTotale.slice(0,3)
    console.log('Versione='+version)
    

    if(stringaTotale.slice(3,4)==='1'){
        var id=stringaTotale.slice(3,6)
        console.log('ID='+id)
        for (let i = 0; i < array.length; i++) {
            const element = array[i];
            
        }
            var id=stringaTotale.slice(3,5)
            console.log
            let daCalcolare=stringaTotale.slice(8,stringaTotale.length)
            console.log(daCalcolare)
    }
};
step2("304")

import './App.css'

function App() {
    function tossCoin() {
        // eslint-disable-next-line react-hooks/purity
        return Math.random() > 0.5 ? "heads" : "tails";
    }

    function fiveHeadsSync() {
        let headsCount = 0;
        let attempts = 0;
        while(headsCount < 5) {
            attempts++;
            let result = tossCoin();
            console.log(`${result} was flipped`);
            if(result === "heads") {
                headsCount++;
            } else {
                headsCount = 0;
            }
        }
        return `It took ${attempts} tries to flip five "heads"`;
    }

    function fiveHeads() {
        return new Promise( (resolve, reject) => {
            resolve(fiveHeadsSync())
            reject("Rejected")
        });
    }
    fiveHeads()
        .then( res => console.log(res) )
        .catch( err => console.log(err) );
    console.log( "When does this run now?" );

    return (
        <>

        </>
    )
}

export default App

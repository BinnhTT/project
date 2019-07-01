//Import React and ReactDOM libraries

import React from 'react';
import ReactDOM from 'react-dom';

// function getButtonText(){
//     return 'click';
// }

//Create a react component

const App = () => {
    const buttonText = { textOne: 'click', textTwo: 'Click on!!!' };
    const style = { backgroundColor: 'blue', color: 'white' };
    return ( <
        div >
        <
        label className = "label"
        htmlFor = "name" > { labelText } <
        /label> <
        input id = "name"
        type = "text" / >
        <
        button style = { style } > { buttonText.textTwo } <
        /button> <
        /div>
    );
};
const labelText = 'Enter name: ';
//Take the react component and show it on your screen
ReactDOM.render( < App / > , document.querySelector('#root'));
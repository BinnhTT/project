import './SeasonDisplay.css';
import React from 'react';

const seasonConfig = {
    summer: {
        text: "FUCK THE BEACH",
        icon: 'sun'
    },
    winter: {
        text: 'So Cool!!!!',
        icon: 'snowflake'
    }
}
const getSeason = (lat, month) => {
    if(month > 2 && month < 9){
        return lat > 0 ? 'summer' : 'winter';
    } else {
        return lat > 0 ? 'winter' : 'summer';
    }
}

const SeasonDisplay = props => {

    const season = getSeason(props.lat, new Date().getMonth());
    const {text, icon} = seasonConfig[season];
    return (
        <div className={`season-display ${season}`}>
            <i className={`icon-left massive ${icon} icon`} />
            <h1>{text}</h1>
            <i className={`icon-right massive ${icon} icon`} />
        </div>
    );
};

export default SeasonDisplay;
//import libraries
import React from 'react';
import ReactDOM from 'react-dom';
import faker from 'faker';
import CommentDetail from './CommentDetail';
import ApprovalCard from './ApprovalCard';
//components

const App = () => {
    return ( <
        div className = "ui container comments" >
        <
        ApprovalCard >
        <
        CommentDetail avatar = { faker.image.avatar() }
        author = "Sam"
        timeAgo = "Today at 9:00AM"
        content = "Exellent!!!" /
        >
        <
        /ApprovalCard> <
        ApprovalCard >
        <
        CommentDetail avatar = { faker.image.avatar() }
        author = "Binh"
        timeAgo = "Today at 4:30AM"
        content = "Good job!!!" /
        >
        <
        /ApprovalCard> <
        ApprovalCard >
        <
        CommentDetail avatar = { faker.image.avatar() }
        author = "Minh"
        timeAgo = "Yesterday at 2:00PM"
        content = "Really nigga!!!" /
        >
        <
        /ApprovalCard>

        <
        /div>
    );
}

//display

ReactDOM.render( < App / > , document.querySelector('#root'));
import React from 'react';
import 'react-h5-audio-player/lib/styles.css';
import './Comment.css';

function Comment({ img, title, comment, audio, setSelectedAudio }) {
    const handleClick = () => {
        setSelectedAudio(audio);
    };

    return (
        <div className="container">
            <div onClick={handleClick} className="wrapper">
                <div className="imageContainer">
                    <img src={img} className="image" alt="사용자 이미지" />
                </div>
                <div className="contentContainer">
                    <span className="titleText">{title}</span>
                    <span className="commentText">{comment}</span>
                </div>
            </div>
        </div>
    );
}

export default Comment;

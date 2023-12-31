import React, { useState } from 'react';
import Comment from './Comment';
import AudioPlayer from './AudioPlayer';
import audio1 from "../music/스토커.mp3";
import audio2 from "../music/봄이좋냐.mp3";
import audio3 from "../music/폰서트.mp3";
import audio4 from "../music/이밤을빌려말해요.mp3";
import audio5 from "../music/가진다는말은좀그렇지.mp3";
import audio6 from "../music/열심히할게.mp3";
import audio7 from "../music/매트리스.mp3";
import audio8 from "../music/그라데이션.mp3";
import audio9 from "../music/입김.mp3";
import audio10 from "../music/이밤이다가기전에오늘이어제가되기전에.mp3";

const CommentList = () => {
    const audios = [ { title: '스토커', audio: audio1, img: 'https://image.bugsm.co.kr/album/images/200/4631/463142.jpg?version=20200111002327.0' },
    { title: '봄이 좋냐', audio: audio2, img: 'https://image.bugsm.co.kr/album/images/500/200286/20028618.jpg' },
    { title: '폰서트', audio: audio3, img: 'https://image.bugsm.co.kr/album/images/200/201168/20116852.jpg?version=20230110011420.0' },
    { title: '이밤을 빌려 말해요', audio: audio4, img: 'https://image.bugsm.co.kr/album/images/200/40266/4026624.jpg?version=20230103025902.0' },
    { title: '가진다는 말은 좀 그렇지?', audio: audio5, img: 'https://image.bugsm.co.kr/album/images/200/40672/4067276.jpg?version=20230516022839.0' },
    { title: '열심히 할게', audio: audio6, img: 'https://image.bugsm.co.kr/album/images/200/40672/4067276.jpg?version=20230516022839.0' },
    { title: '매트리스', audio: audio7, img: 'https://image.bugsm.co.kr/album/images/200/201886/20188681.jpg?version=20210927165006.0' },
    { title: '그라데이션', audio: audio8, img: 'https://image.bugsm.co.kr/album/images/200/40773/4077389.jpg?version=20220706005646.0' },
    { title: '입김', audio: audio9, img: 'https://image.bugsm.co.kr/album/images/200/40207/4020725.jpg?version=20230131183004.0' },
    { title: '이 밤이 다 가기 전에 오늘이 어제가 되기 전에', audio: audio10, img: 'https://image.bugsm.co.kr/album/images/200/40207/4020725.jpg?version=20230131183004.0' },
    ];
    const [selectedAudio, setSelectedAudio] = useState(null);  

    return (
        <div>
            {audios.map((audio, index) => (
                <Comment 
                    key={index}
                    title={audio.title} 
                    audio={audio} 
                    img={audio.img} 
                    setSelectedAudio={setSelectedAudio}
                />
            ))}
            <AudioPlayer
                audios={audios}  
                selectedAudio={selectedAudio}
            />
        </div>
    );
}

export default CommentList;




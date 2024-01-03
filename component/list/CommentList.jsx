import styled from 'styled-components';
import CommentListItem from './CommentListItem';

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    margin-bottom: 20px;
`;

function CommentList(props) {
    const { comments } = props;

    return (
        <Wrapper>
            {comments.map((comment) => {
                return <CommentListItem
                            key = {comment.id}
                            comment = {comment} />;
            })}
        </Wrapper>
    )
}

export default CommentList;